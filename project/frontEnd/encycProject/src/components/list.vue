<template>
  <div class="list">
    <van-list
      v-model="loading"
      :finished="finished"
      finished-text="没有更多了"
      @load="onLoad"
      :error.sync="error"
      error-text="请求失败，点击重新加载"
    >
      <van-cell v-for="item in list" :key="item.id" :title="item.title" icon="new">
        <van-button plain icon="label-o" type="primary" @click="check(item)">详情</van-button>
      </van-cell>
    </van-list>
    <van-popup v-model="show" position="bottom" :style="{ height: '98%' }">
      <van-panel :title="tit" desc="宠物百科" status="阅读">
        <div class="con">{{content}}</div>
        <div slot="footer" class="bu">
          <van-button size="small" type="danger" @click="close">close</van-button>
        </div>
      </van-panel>
    </van-popup>
  </div>
</template>
<script>
export default {
  data() {
    return {
      list: [],
      finished: false,
      error: false,
      loading: false,
      title: "",
      start: 0,
      counts: 0,
      show: false,
      content: "",
      tit: ""
    };
  },
  methods: {
    onLoad() {
      //异步获取数据
      this.axios
        .get("/apis/query", {
          params: {
            title: this.title,
            start: this.start
          }
        })
        .then(response => {
          var jsonObj = JSON.parse(JSON.stringify(response.data));
          //总数
          this.counts = response.data.count;
          for (var i = 0; i < jsonObj.list.length; i++) {
            this.list.push(jsonObj.list[i]);
          }
          this.start = this.list.length;
          this.loading = false;
          if (this.list.length >= this.counts) {
            this.finished = true;
          }
        })
        .catch(error => {
          this.error = true;
        });
    },
    check(content, event) {
      this.show = true;
      this.tit = content.title.substring(1, content.title.length - 1);
      this.content = content.content.substring(1, content.content.length - 1);
    },
    close() {
      this.show = false;
    }
  },
  created() {
    //获取传入的参数
    var param = this.$route.query.title;
    // var param = this.$route.params;
    this.title = param;
  }
};
</script>
<style scoped>
.list {
  margin-top: 50px;
}
.con{
  margin: 0;
  padding-left: 10px;
  padding-right: 10px;
}
.bu{
  padding-left: 80%
}
</style>


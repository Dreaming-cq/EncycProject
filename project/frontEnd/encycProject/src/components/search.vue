<template>
  <div class="search">
    <van-search v-model="value" placeholder="请输入搜索关键词" show-action shape="round" @search="onSearch">
      <div slot="action" @click="onSearch">搜索</div>
    </van-search>
  </div>
</template>
<style scoped>
.search{
    margin-top: 60%
}

</style>
<script>

export default {
    data(){
        return {
            value:''
        }
    },
    methods:{
        onSearch(){
            this.$router.push({
               path: '/search/list',
                query: {
                    title:this.value
                }
            }
            );
              
        }
    }
};
</script>


<template>
  <div id="app">
    <!-- header -->
    <van-nav-bar title="宠物乐园" fix='true' @click-right="onClickRight" fixed=true>
      <van-icon name="manager" slot="right"/>
    </van-nav-bar>
    <!-- body -->
    <transition>
      <router-view></router-view>
    </transition>
    <!-- tabber -->
    <van-tabbar v-model="active" route>
      <van-tabbar-item to="/home" name="home" icon="home-o">主页</van-tabbar-item>
      <van-tabbar-item to="/toSearch" name="search" icon="search">搜索</van-tabbar-item>
    </van-tabbar>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      active: "home"
    };
  },
  methods: {
    onClickRight() {
      this.$router.push("/toLogin");
      
    }
  }
};
</script>
<style scoped>
</style>



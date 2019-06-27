import Vue from 'vue'
import Router from 'vue-router'
import Search from '../components/Search.vue'
import Login from '../components/login.vue'
import Listt from '../components/list.vue'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: "/toSearch",
      name: "search",
      component: Search
    }, 
    {
      path: '/toLogin',
      name: "login",
      component: Login
    },
    {
      path: '/search/list',
      name: 'list',
      component: Listt
    }
  ]
})

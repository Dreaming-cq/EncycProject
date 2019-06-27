// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import { NavBar } from "vant";
import { Tabbar, TabbarItem } from 'vant';
//引入样式

// import 'vant/lib/index.css';
import { Search } from 'vant';
import { Icon } from 'vant';
import { Field } from 'vant';
import { Button } from 'vant';
import { Toast } from 'vant';
import { List } from 'vant';
import { Cell, CellGroup } from 'vant';
// ajax axios
import axios from 'axios'
import qs from 'qs'
import VueAxios from 'vue-axios'
import { PullRefresh } from 'vant';
import { Popup } from 'vant';
import { Panel } from 'vant';

Vue.use(Panel);
Vue.use(Popup);

Vue.use(PullRefresh);
Vue.use(VueAxios,axios);
Vue.prototype.qs=qs



//
Vue.use(Cell).use(CellGroup);
Vue.use(List);
Vue.use(Toast);
Vue.use(Button);
Vue.use(Field);
Vue.use(Icon);
Vue.use(Search);
Vue.use(NavBar);
Vue.use(Tabbar).use(TabbarItem);
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

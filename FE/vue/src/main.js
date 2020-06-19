import Vue from 'vue';
import App from './App.vue';
import router from '@/routes/index';
import store from '@/store/index';
import Fragment from 'vue-fragment';
import SuiVue from 'semantic-ui-vue';

Vue.config.productionTip = false;

Vue.use(Fragment.Plugin);
Vue.use(SuiVue);

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app');

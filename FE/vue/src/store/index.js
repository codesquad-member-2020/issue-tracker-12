import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    labelCount: 0,
    milestoneCount: 0,
  },
  mutations: {},
});

export default store;

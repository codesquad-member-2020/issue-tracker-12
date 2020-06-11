import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    labelCount: 0,
    milestoneCount: 0,
    toggleColor: false,
  },
  mutations: {},
});

export default store;

import Vue from 'vue';
import Vuex from 'vuex';
import _ from '@/utils/utils';

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    isCreateLabel: false,
    previewStyle: '',
    labelName: '' || 'Label Preview',
    labelCount: 0,
    milestoneCount: 0,
    toggleColor: false,
    labelNameError: false,
    labels: [
      {
        id: 1,
        textColor: '#fff',
        backgroundColor: 'rgb(203,92,208)',
        description: 'testing label',
        labelName: 'duplicate',
      },
      {
        id: 2,
        textColor: '#fff',
        backgroundColor: 'rgb(254,40,119)',
        description: 'testing label',
        labelName: 'FE',
      },
      {
        id: 3,
        textColor: '#fff',
        backgroundColor: 'rgb(86,185,42)',
        description: 'testing label',
        labelName: 'good first issue',
      },
      {
        id: 4,
        textColor: '#fff',
        backgroundColor: 'rgb(118,148,231)',
        description: 'testing label',
        labelName: 'help wanted',
      },
      {
        id: 5,
        textColor: '#000',
        backgroundColor: 'rgb(128,177,104)',
        description: 'testing label',
        labelName: 'question',
      },
    ],
  },
  mutations: {
    changeLabelName(state, labelName) {
      if (labelName == '') return (state.labelName = '' || 'Label Preview');
      state.labelName = labelName;
    },

    setPreviewStyle(state) {
      const previewStyle = _.pipe(
        _.createRandomHexColor,
        _.hexToLuma,
        _.isWhiteColor,
      )();
      state.previewStyle = previewStyle;
    },
    visableCreateLabel(state) {
      state.isCreateLabel = !state.isCreateLabel;
    },
    addToLabelList(state, payload) {
      const obj = {
        id: state.labels.length + 1,
        ...state.previewStyle,
        ...payload,
      };
      console.log(obj);
      state.labels.push(obj);
    },
    deleteLabel(state, labelId) {
      state.labels = state.labels.filter(
        label => label.id !== parseInt(labelId),
      );
    },
  },
});

export default store;

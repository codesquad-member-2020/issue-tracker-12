import Vue from 'vue';
import Vuex from 'vuex';
import _ from '@/utils/utils';

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    isEdit: false,
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
        backgroundColor: '#CB5CD0',
        description: 'testing label',
        labelName: 'duplicate',
      },
      {
        id: 2,
        textColor: '#fff',
        backgroundColor: '#FA2877',
        description: 'testing label',
        labelName: 'FE',
      },
      {
        id: 3,
        textColor: '#fff',
        backgroundColor: '#56B92A',
        description: 'testing label',
        labelName: 'good first issue',
      },
      {
        id: 4,
        textColor: '#fff',
        backgroundColor: '#7694E7',
        description: 'testing label',
        labelName: 'help wanted',
      },
      {
        id: 5,
        textColor: '#000',
        backgroundColor: '#80B168',
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
      state.labels.push(obj);
    },
    deleteLabel(state, labelId) {
      state.labels = state.labels.filter(
        label => label.id !== parseInt(labelId),
      );
    },
    editLabel(state) {
      state.isEdit = !state.isEdit;
    },
    saveLabel(state, labelInfo) {
      let target = state.labels.filter(label => label.id === labelInfo.id);
      Object.assign(target[0], labelInfo);
    },
  },
});

export default store;

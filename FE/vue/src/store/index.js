import Vue from 'vue';
import Vuex from 'vuex';
import _ from '@/utils/utils';

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    isOpenMilestone: true,
    openMilestoneCount: 0,
    closeMilestoneCount: 0,
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
    milestonesList: [
      {
        id: 1,
        title: '마일스톤 1',
        dueDate: '2020-06-26',
        description: '이번 배포를 위한 스프린트1',
        isOpen: true,
        linkIssues: [
          {
            isOpen: true,
          },
          {
            isOpen: true,
          },
          {
            isOpen: false,
          },
        ],
      },
      {
        id: 2,
        title: '[Vue] 마일스톤 목록 생성',
        dueDate: '2020-06-26',
        description: '마일스톤 목록을 추가한다',
        isOpen: true,
        linkIssues: [
          {
            isOpen: true,
          },
          {
            isOpen: true,
          },
          {
            isOpen: true,
          },
        ],
      },
      {
        id: 3,
        title: 'Vue component 생성',
        dueDate: '2020-07-16',
        description: 'Vue component 추가',
        isOpen: false,
        linkIssues: [
          {
            isOpen: true,
          },
          {
            isOpen: false,
          },
          {
            isOpen: false,
          },
        ],
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
    openMilestone(state) {
      state.isOpenMilestone = true;
    },
    closeMilestone(state) {
      state.isOpenMilestone = false;
    },
  },
});

export default store;

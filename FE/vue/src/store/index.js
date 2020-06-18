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
    issue: {
      count: 5,
      data: [
        {
          id: 1,
          title: 'issue title 1',
          githubId: 'wooody92',
          createTime: '2020-06-10',
          status: 'OPEN',
          comment: 3,
          milestone: {
            id: 1,
            title: 'milestone title 1',
          },
          labels: [
            {
              name: 'label BE',
              textColor: '#fff',
              backgroundColor: '#CB5CD0',
            },
            {
              name: 'label FE',
              textColor: '#fff',
              backgroundColor: '#FA2877',
            },
            {
              name: 'label OS',
              textColor: '#000',
              backgroundColor: '#56B92A',
            },
          ],
        },
        {
          id: 2,
          title: 'issue title 2',
          githubId: 'wooody92',
          createTime: '2020-06-10',
          status: 'OPEN',
          comment: 1,
          milestone: {
            id: 1,
            title: 'milestone title 1',
          },
          labels: [
            {
              name: 'label BE',
              textColor: '#fff',
              backgroundColor: '#CB5CD0',
            },
            {
              name: 'label KM',
              textColor: '#fff',
              backgroundColor: '#7694E7',
            },
          ],
        },
        {
          id: 3,
          title: 'issue title 3',
          githubId: 'wooody92',
          createTime: '2020-06-10',
          status: 'OPEN',
          comment: 1,
          milestone: {
            id: 1,
            title: 'milestone title 1',
          },
          labels: [
            {
              name: 'label GG',
              textColor: '#000',
              backgroundColor: '#80B168',
            },
          ],
        },
      ],
    },
    user: {
      count: 2,
      data: [
        {
          githubId: 'wooody92',
          profileUrl: 'www.image1.com',
        },
        {
          githubId: 'henry',
          profileUrl: 'www.image2.com',
        },
      ],
    },
    label: {
      count: 5,
      data: [
        {
          id: 1,
          name: 'label BE',
          description: 'dev BE',
          textColor: '#fff',
          backgroundColor: '#CB5CD0',
        },
        {
          id: 2,
          name: 'label FE',
          description: 'dev FE',
          textColor: '#fff',
          backgroundColor: '#FA2877',
        },
        {
          id: 3,
          name: 'label OS',
          description: 'dev OS',
          textColor: '#000',
          backgroundColor: '#56B92A',
        },
        {
          id: 4,
          name: 'label KM',
          description: 'dev KM',
          textColor: '#fff',
          backgroundColor: '#7694E7',
        },
        {
          id: 5,
          name: 'label GG',
          description: 'dev GG',
          textColor: '#000',
          backgroundColor: '#80B168',
        },
      ],
    },
    milestone: {
      count: 2,
      data: [
        {
          id: 1,
          title: 'milestone title 1',
        },
        {
          id: 2,
          title: 'milestone title 2',
        },
      ],
    },
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
    createMilestone(state, payload) {
      state.milestonesList.push(payload);
    },
    closedMilestoneItem(state, targetId) {
      const targetMilestone = state.milestonesList.filter(
        item => item.id == targetId,
      );
      Object.assign(targetMilestone[0], { isOpen: false });
      state.isOpenMilestone = false;
    },
    reopenMilestoneItem(state, targetId) {
      const targetMilestone = state.milestonesList.filter(
        item => item.id == targetId,
      );
      Object.assign(targetMilestone[0], { isOpen: true });
      state.isOpenMilestone = true;
    },
    deleteMilestoneItem(state, targetId) {
      const targetMilestone = state.milestonesList.filter(
        item => item.id != targetId,
      );
      state.milestonesList = targetMilestone;
    },
    saveChangeMilestone(state, payload) {
      const targetMilestone = state.milestonesList.filter(
        item => item.id == payload.id,
      );
      Object.assign(targetMilestone[0], payload.data);
    },
  },
});

export default store;

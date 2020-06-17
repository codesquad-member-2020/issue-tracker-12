import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/labelList',
    },
    {
      path: '/login',
      component: () => import('@/views/LoginPage.vue'),
    },
    {
      path: '/issueList',
      component: () => import('@/views/IssueListPage.vue'),
    },
    {
      path: '/createIssue',
      component: () => import('@/views/CreateIssuePage.vue'),
    },
    {
      path: '/detailIssue/:id',
      component: () => import('@/views/DetailIssuePage.vue'),
    },
    {
      path: '/labelList',
      component: () => import('@/views/LabelListPage.vue'),
    },
    {
      path: '/milestoneList',
      component: () => import('@/views/MilestoneListPage.vue'),
    },
    {
      path: '/createMilestone',
      component: () => import('@/views/CreateMilestonePage.vue'),
    },
    {
      path: '/createMilestone/:id',
      component: () => import('@/views/CreateMilestonePage.vue'),
    },
  ],
});

export default router;

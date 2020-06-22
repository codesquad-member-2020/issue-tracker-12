<template>
  <div class="wrapper">
    <div class="issue-table">
      <div>
        <input class="checkboxInput" type="checkbox" @change="checkedItem" />
        <img class="issueIcon" src="../../../assets/issueIcon.svg" alt="" />
        <span class="issue-title">{{ item.title }}</span>
        <LabelWrap v-for="label in item.labels" :key="label.index">
          <issueLabel :label="label">
            {{ label.name }}
          </issueLabel>
        </LabelWrap>
      </div>
      <div class="issue-detail">
        <span>#{{ item.id }}</span>
        <span> {{ item.status }}</span>
        <span> {{ item.createTime }}</span>
        <span> by {{ item.githubId }}</span>
        <span :if="item.milestone.length > 0">
          <img
            class="issueMilestone"
            src="../../../assets/issueMilestone.svg"
            alt=""
          />
          {{ item.milestone.title }}
        </span>
      </div>
    </div>
    <div class="container">
      <span v-if="item.assignee">
        <img class="assingnee-icon" :src="item.assignee" />
      </span>
      <span v-else></span>
      <span v-if="item.comment">
        <img class="comment-svg" src="../../../assets/comment.svg" alt="" />
        <span class="comment-number">{{ item.comment }}</span>
      </span>
      <span v-else></span>
    </div>
  </div>
</template>

<script>
import { issueLabel, LabelWrap } from '@/style/styled';

export default {
  props: ['item'],
  components: {
    issueLabel,
    LabelWrap,
  },
  methods: {
    checkedItem({ target: { checked } }) {
      console.log(checked);
    },
  },
};
</script>

<style lang="scss" scoped>
.comment-number {
  font-size: 12px;
  font-weight: 600;
  color: #586069;
  vertical-align: top;
  margin-left: 5px;
}

.comment-svg {
  width: 16px;
  height: 16px;
  filter: invert(37%) sepia(2%) saturate(3625%) hue-rotate(172deg)
    brightness(87%) contrast(74%);
}

.assingnee-icon {
  width: 20px;
  height: 20px;
}

.wrapper {
  display: flex;
  width: 100%;
}

.container {
  width: 30%;
  display: flex;
  justify-content: space-around;
  padding: 0px 15px;
}

.issue-title {
  font-size: 16px;
  font-weight: 600;
  color: #24292e;
}

.issue-table {
  display: flex;
  flex-direction: column;
  width: 70%;
}
.issueIcon {
  vertical-align: text-bottom;
  filter: invert(51%) sepia(84%) saturate(379%) hue-rotate(82deg)
    brightness(86%) contrast(100%);
  margin: 0 10px 0px 5px;
}

.issueMilestone {
  vertical-align: text-bottom;
  margin-left: 10px;
  filter: invert(81%) sepia(34%) saturate(7%) hue-rotate(95deg) brightness(97%)
    contrast(90%);
}

.checkboxInput {
  margin: 0px 10px;
}

.issue-detail {
  margin-top: 5px;
  margin-left: 62px;
}
</style>

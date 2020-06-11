<template>
  <div class="label-container" @click="toLabelsPage" :style="[theme]">
    <svg
      class="octicon octicon-tag"
      version="1.1"
      width="16"
      height="16"
      aria-hidden="true"
    >
      <path
        fill-rule="evenodd"
        d="M2.5 7.775V2.75a.25.25 0 01.25-.25h5.025a.25.25 0 01.177.073l6.25 6.25a.25.25 0 010 .354l-5.025 5.025a.25.25 0 01-.354 0l-6.25-6.25a.25.25 0 01-.073-.177zm-1.5 0V2.75C1 1.784 1.784 1 2.75 1h5.025c.464 0 .91.184 1.238.513l6.25 6.25a1.75 1.75 0 010 2.474l-5.026 5.026a1.75 1.75 0 01-2.474 0l-6.25-6.25A1.75 1.75 0 011 7.775zM6 5a1 1 0 100 2 1 1 0 000-2z"
      ></path>
    </svg>
    <span class="labels-title">Labels</span>
    <slot></slot>
  </div>
</template>

<script>
export default {
  props: ['theme'],
  data() {
    return {
      baseStyles: {
        fontWeight: '800',
        color: 'red',
      },
    };
  },
  methods: {
    toLabelsPage() {
      this.$router.push('/labelList');
    },
  },
};
</script>

<style lang="scss" scoped>
.label-container {
  margin-left: 15px;
  cursor: pointer;
  display: flex;
  vertical-align: middle;
  position: relative;
  float: left;
  padding: 6px 14px;
  font-weight: 600;
  line-height: 20px;
  color: #586069;
  border: 1px solid #e1e4e8;
  border-top-left-radius: 3px;
  border-bottom-left-radius: 3px;
}

.label-container:hover {
  text-decoration: none;
  background-color: #f6f8fa;
}

.octicon {
  display: inline-block;
  vertical-align: text-top;
  fill: currentColor;
}

.label-counter {
  padding: 4px 5px;
  font-size: 12px;
  font-weight: 600;
  line-height: 1;
  color: #586069;
  background-color: rgba(27, 31, 35, 0.08);
  border-radius: 20px;
}

.labels-title {
  margin: 0px 5px;
}
</style>

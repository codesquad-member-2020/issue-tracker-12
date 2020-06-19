<template>
  <SelectWrapper>
    <sui-dropdown text="Filters" button pointing>
      <sui-dropdown-menu @click="clicked">
        <div>Filter Issues</div>
        <fragment v-for="option in filter" :key="option.key">
          <sui-dropdown-item>{{ option }}</sui-dropdown-item>
        </fragment>
      </sui-dropdown-menu>
    </sui-dropdown>
    <div class="svgContainer">
      <img class="search" src="../../../assets/search.svg" alt="" />
      <input type="text" />
    </div>
  </SelectWrapper>
</template>

<script>
import { SelectWrapper } from '@/style/styled';

export default {
  data() {
    return {
      filter: [
        'Open issues and pull requests',
        'Your issues',
        'Your pull requests',
        'Everything assigned to you',
        'Everything mentioning you',
      ],
    };
  },
  components: {
    SelectWrapper,
  },
  methods: {
    clicked(e) {
      console.log(e.target.innerText);
    },
  },
};
</script>

<style lang="scss" scoped>
.ui.button {
  width: 85px;
  background-color: #eff3f6;
  border: 1px solid rgba(27, 31, 35, 0.2);
  color: #444d56;
  font-size: 14px;
  box-sizing: border-box;
  font-weight: 600;
  padding: 6px 12px;
  font-size: 14px;
  font-weight: 600;
  line-height: 20px;
  white-space: nowrap;
  vertical-align: middle;
  border-right: none;
  margin: 0px;
  border-radius: 0px;
  border-top-left-radius: 3px;
  border-bottom-left-radius: 3px;
  font-family: -apple-system, BlinkMacSystemFont, Segoe UI, Helvetica, Arial,
    sans-serif, Apple Color Emoji, Segoe UI Emoji;
}

.svgContainer {
  display: inline-block;
  position: relative;
}
.search {
  position: absolute;
  top: 10px;
  left: 8px;
  display: block;
  filter: invert(97%) sepia(2%) saturate(1109%) hue-rotate(180deg)
    brightness(84%) contrast(93%);
  text-align: center;
  pointer-events: none;
}
</style>

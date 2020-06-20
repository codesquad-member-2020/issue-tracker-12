<template>
  <fragment>
    <sui-dropdown
      class="filter-item-wrap"
      :text="filterTitle"
      floating
      labeled
      v-model="selectedValue"
      :menu-header="menuHeader"
      :search-in-menu="searchInMenu"
      :options="options"
      @click="filteredData"
    >
    </sui-dropdown>
  </fragment>
</template>

<script>
import { mapState } from 'vuex';

export default {
  props: ['filterTitle'],
  updated() {
    const labelItem = document.querySelectorAll('.empty');
    const labelColor = Array.from(labelItem);
    labelColor.map(
      (i, index) =>
        (i.style.backgroundColor = this.$store.state.label.data[
          index
        ].backgroundColor),
    );
  },
  data() {
    return {
      menuHeader: {
        icon: '',
        content: 'Header',
      },
      searchInMenu: {
        icon: 'search',
        iconPosition: 'left',
      },
      selectedValue: null,
      options: [],
    };
  },
  computed: {
    ...mapState(['user']),
  },
  methods: {
    filteredData() {
      if (this.filterTitle === 'Author') {
        this.options = this.$store.state.user.data.map(user => ({
          text: user.githubId,
          image: { src: user.profileUrl, avatar: true },
        }));
      } else if (this.filterTitle === 'Label') {
        this.options = this.$store.state.label.data.map(label => ({
          text: label.name,
          label: { empty: true, circular: true },
        }));
      } else if (this.filterTitle === 'Milestone') {
        this.options = this.$store.state.milestone.data.map(milestone => ({
          text: milestone.title,
        }));
      } else {
        this.options = this.$store.state.user.data.map(user => ({
          text: user.githubId,
          image: { src: user.profileUrl, avatar: true },
        }));
      }
    },
  },
};
</script>

<style lang="scss" scoped>
.filter-item-wrap {
  margin-right: 20px;
}
</style>

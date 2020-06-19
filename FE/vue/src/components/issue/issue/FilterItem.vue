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
    console.log(document.querySelectorAll('.empty'));

    document.querySelector('.empty').style.backgroundColor = 'red';
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
        this.options = this.$store.state.user.data.map(i => ({
          text: i.githubId,
          image: { src: i.profileUrl, avatar: true },
        }));
      } else if (this.filterTitle === 'Label') {
        this.options = this.$store.state.label.data.map(i => ({
          text: i.name,
          label: { empty: true, circular: true },
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

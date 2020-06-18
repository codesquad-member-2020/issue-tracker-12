<template>
  <fragment>
    <sui-dropdown
      :text="filterTitle"
      floating
      labeled
      button
      v-model="selectedValue"
      :menu-header="menuHeader"
      :search-in-menu="searchInMenu"
      :options="options"
      @click="test"
    />
  </fragment>
</template>

<script>
export default {
  props: ['filterTitle'],
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
  methods: {
    test() {
      if (this.filterTitle === 'Author') {
        this.options = [
          {
            // key: 'Important',
            text: 'Important',
            // value: 'Important',
            label: {
              color: 'red',
              empty: true,
              circular: true,
            },
          },
        ];
      }
      // this.$store.state.user.data.map(i => {
      //   this.options.text = i.githubId;
      //   this.options.label
      // });
    },
  },
};
</script>

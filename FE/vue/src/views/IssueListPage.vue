<template>
  <fragment>
    <div>
      <FilterComponent />
      <LmButton />
      <NewCreateButton :title="btnTittle" />
    </div>
  </fragment>
</template>

<script>
import FilterComponent from '@/components/issueList/FilterComponent';
import LmButton from '@/components/mixinContent/LmButton';
import NewCreateButton from '@/components/button/NewCreateButton';

export default {
  data() {
    return {
      btnTittle: 'New issue',
    };
  },
  components: {
    FilterComponent,
    LmButton,
    NewCreateButton,
  },
};
</script>

<style lang="scss" scoped></style>

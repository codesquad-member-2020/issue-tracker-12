<template>
  <Hedaer>
    <FilterComponent></FilterComponent>
    <div class="btn-box">
      <RouterBox></RouterBox>
      <CreateButton :btnTitle="'New issue'"></CreateButton>
    </div>
  </Hedaer>
</template>

<script>
import { Hedaer } from '@/style/styled';
import FilterComponent from '@/components/issue/issue/FilterComponent';
import RouterBox from '@/components/common/RouterBox';
import CreateButton from '@/components/common/CreateButton';
export default {
  components: {
    Hedaer,
    FilterComponent,
    RouterBox,
    CreateButton,
  },
};
</script>

<style lang="scss" scoped>
.btn-box {
  display: flex;
}
</style>

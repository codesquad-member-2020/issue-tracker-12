<template>
  <Hedaer>
    <HeaderFilter></HeaderFilter>
    <div class="btn-box">
      <RouterBox></RouterBox>
      <CreateButton :btnTitle="'New issue'"></CreateButton>
    </div>
  </Hedaer>
</template>

<script>
import { Hedaer } from '@/style/styled';
import HeaderFilter from '@/components/issue/issue/HeaderFilter';
import RouterBox from '@/components/common/RouterBox';
import CreateButton from '@/components/common/CreateButton';
export default {
  components: {
    Hedaer,
    HeaderFilter,
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

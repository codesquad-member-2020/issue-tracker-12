<template>
  <Hedaer class="headerContainer">
    <RouterBox />
    <CreateButton
      :btnTitle="'New milestone'"
      @click.native="createMilestone"
    ></CreateButton>
  </Hedaer>
</template>

<script>
import RouterBox from '@/components/common/RouterBox';
import CreateButton from '@/components/common/CreateButton';
import { Hedaer } from '@/style/styled';

export default {
  components: {
    RouterBox,
    CreateButton,
    Hedaer,
  },

  methods: {
    createMilestone() {
      this.$router.push('/createMilestone');
    },
  },
};
</script>

<style lang="scss" scoped></style>

<template>
  <GlobalContainer id="app">
    <router-view></router-view>
  </GlobalContainer>
</template>

<script>
import { GlobalContainer } from '@/style/globalStyle';

export default {
  components: {
    GlobalContainer,
  },
};
</script>

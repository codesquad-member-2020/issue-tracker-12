<template>
  <div>
    <HeaderComponent></HeaderComponent>
    <ContentComponent></ContentComponent>
  </div>
</template>

<script>
import HeaderComponent from '@/components/issue/milestone/HeaderComponent';
import ContentComponent from '@/components/issue/milestone/ContentComponent';

export default {
  components: {
    HeaderComponent,
    ContentComponent,
  },
};
</script>

<style></style>

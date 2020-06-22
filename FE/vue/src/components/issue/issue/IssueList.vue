<template>
  <fragment>
    <issueListContainer v-for="item in issue.data" :key="item.index">
      <IssueItem :item="item" />
    </issueListContainer>
  </fragment>
</template>

<script>
import { mapState } from 'vuex';
import IssueItem from '@/components/issue/issue/IssueItem';
import { issueListContainer } from '@/style/styled';

export default {
  computed: {
    ...mapState(['issue']),
  },
  components: {
    IssueItem,
    issueListContainer,
  },
};
</script>

<style></style>

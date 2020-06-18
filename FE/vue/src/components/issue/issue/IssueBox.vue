<template>
  <ListTopMenu>
    <BtnWrapper class="btnWrapper">
      <ItemWrapper>
        <input type="checkbox" />
        <StateIssueButton :type="open" />
        <StateIssueButton :type="close" />
      </ItemWrapper>
      <ItemWrapper>
        <FilterItem :filterTitle="'Author'" />
      </ItemWrapper>
    </BtnWrapper>
  </ListTopMenu>
</template>

<script>
import { ListTopMenu, BtnWrapper, ItemWrapper } from '@/style/styled';
import StateIssueButton from '@/components/issue/issue/StateIssueButton';
import FilterItem from '@/components/issue/issue/FilterItem';

export default {
  data() {
    return {
      open: 'open',
      close: 'close',
    };
  },
  components: {
    ListTopMenu,
    BtnWrapper,
    StateIssueButton,
    ItemWrapper,
    FilterItem,
  },
};
</script>

<style lang="scss" scoped>
.btnWrapper {
  color: #586069;
  font-weight: 400;
  width: 100%;
  justify-content: space-between;
  input {
    margin-top: 4px;
    margin-right: 15px;
  }
}
</style>

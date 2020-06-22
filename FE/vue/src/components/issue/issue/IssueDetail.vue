<template>
  <fragment>
    <div class="issue-edit">
      <div>
        <span>image</span>
      </div>
      <CreateIssueWrap>
        <input type="text" placeholder="Title" />
        <WriteContainer>
          <WriteBtn>
            Write
          </WriteBtn>
        </WriteContainer>
      </CreateIssueWrap>
    </div>
  </fragment>
</template>

<script>
import { CreateIssueWrap, WriteContainer, WriteBtn } from '@/style/styled';

export default {
  components: {
    CreateIssueWrap,
    WriteContainer,
    WriteBtn,
  },
};
</script>

<style lang="scss" scoped>
.issue-edit {
  display: flex;
}
</style>

/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import Flex from '@Custom/Flex/Flex';
import Text from '@Components/NewIssue/Text/Text';
import OptionButtons from '@Components/NewIssue/OptionButtons/OptionButtons';

const NewIssue = () => {
  return (
    <Flex customCSS={newIssueWrapper}>
      <Text></Text>
      <OptionButtons />
    </Flex>
  );
};

const newIssueWrapper = css`
  margin-top: 10vh;
  padding: 1rem 3rem;
`;

export default NewIssue;

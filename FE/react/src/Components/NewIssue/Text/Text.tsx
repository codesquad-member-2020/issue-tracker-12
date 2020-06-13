/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import Input from '@Components/NewIssue/Input/Input';
import Tab from '@Custom/Tab/Tab';
import Flex from '@Custom/Flex/Flex';
import Button from '@Custom/Button/Button';

const Text = () => {
  return (
    <Flex direction="column" width="60%" gap="1rem" customCSS={textWrapperStyle}>
      <Input></Input>
      <Tab tabs={['Write', 'Preview']} contentsHeight={'200px'} contentsWidth={'100%'}></Tab>
      <Flex>
        <Button theme="lightgray" width="8%">
          Cancel
        </Button>
        <Button theme="primary" width="15%">
          Submit new issue
        </Button>
      </Flex>
    </Flex>
  );
};

const textWrapperStyle = css`
  background-color: #ffffff;
  border: 1px solid #d1d5da;
  height: 350px;
  padding: 1rem;
`;

export default Text;

/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import Header from '@Components/Main/Header/Header';
import Body from '@Components/Main/Body/Body';
import Flex from '@Custom/Flex/Flex';

const Main = () => {
  return (
    <Flex direction="column" gap="2rem">
      <Header />
      <Body />
    </Flex>
  );
};

const mainStyle = css`
  margin-top: 10vh;
`;
export default Main;

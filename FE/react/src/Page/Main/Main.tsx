/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import Header from '@Components/Main/Header/Header';
import Body from '@Components/Main/Body/Body';
import Flex from '@Custom/Flex/Flex';

const Main = () => {
  return (
    <Flex direction="column" gap="2rem" customCSS={mainWrapper}>
      <Header />
      <Body />
    </Flex>
  );
};

const mainWrapper = css`
  padding: 1rem 3rem;
`;

export default Main;

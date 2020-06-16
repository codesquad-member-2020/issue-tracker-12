/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import Icon from '@Icon/Icon';
import Flex from '@Custom/Flex/Flex';

const Header = () => {
  return (
    <Flex align="center" alignItemCenter={true} gap={10} customCSS={headerStyle}>
      <Icon icon="github" />
      <p>Issue</p>
    </Flex>
  );
};

const headerStyle = css`
  position: fixed;
  top: 0;
  left: 0;
  background-color: #f6f8fa;
  height: 10vh;
  width: 100%;
`;

export default Header;

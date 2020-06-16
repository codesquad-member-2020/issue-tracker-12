/**@jsx jsx */
import { jsx } from '@emotion/core';
import * as icons from './svg';

export type IconType = keyof typeof icons;
export const iconTypes: IconType[] = Object.keys(icons) as any[];

export type IconProps = {
  icon: IconType;
  color?: string;
  size?: string | number;
  className?: string;
  onClick?: () => void;
};

const Icon = ({ icon, color, size, className, onClick }: IconProps) => {
  const SVGIcon = icons[icon];
  return (
    <SVGIcon
      css={{ fill: color || 'currentColor', width: size, height: 'auto' }}
      className={className}
      onClick={onClick}
    />
  );
};

export default Icon;

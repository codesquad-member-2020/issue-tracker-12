const _ = {
  debounce: func => {
    clearTimeout(debounce);

    const debounce = setTimeout(() => {
      func();
    }, 1000);
  },

  pipe: (...functions) => args =>
    functions.reduce((arg, nextFn) => nextFn(arg), args),

  createRandomHexColor: () => {
    const randomColor = '#' + Math.floor(Math.random() * 16777215).toString(16);
    return randomColor;
  },

  createRandomRGBColor: () => {
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);

    return { r, g, b };
  },

  hexToLuma: color => {
    const hex = color.replace(/#/, '');
    const r = parseInt(hex.substr(0, 2), 16);
    const g = parseInt(hex.substr(2, 2), 16);
    const b = parseInt(hex.substr(4, 2), 16);

    const colorNumber =
      [0.299 * r, 0.587 * g, 0.114 * b].reduce((a, b) => a + b) / 255;
    return { backgroundColor: color, number: colorNumber };
  },

  isWhiteColor: ({ backgroundColor, number }) => {
    if (number > 0.5) return { backgroundColor, textColor: '#fff' };
    return { backgroundColor, textColor: '#000' };
  },

  isDarkColor: RGBColors => {
    if (!RGBColors) {
      return null;
    } else {
      const { r, g, b } = RGBColors;
      const yiq = (r * 299 + g * 587 + b * 114) / 1000;
      const textColor = yiq < 150 ? '#fff' : '#000';

      return { r, g, b, textColor };
    }
  },

  changeHexToRgb: hex => {
    if (!hex) {
      return null;
    } else {
      var shorthandRegex = /^#?([a-f\d])([a-f\d])([a-f\d])$/i;
      hex = hex.replace(shorthandRegex, function (m, r, g, b) {
        return r + r + g + g + b + b;
      });

      var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
      return result
        ? {
            r: parseInt(result[1], 16),
            g: parseInt(result[2], 16),
            b: parseInt(result[3], 16),
            hex,
          }
        : null;
    }
  },
  changeRgbToHex: rgb => {
    rgb = rgb.match(
      /^rgba?[\s+]?\([\s+]?(\d+)[\s+]?,[\s+]?(\d+)[\s+]?,[\s+]?(\d+)[\s+]?/i,
    );
    return rgb && rgb.length === 4
      ? '#' +
          ('0' + parseInt(rgb[1], 10).toString(16)).slice(-2) +
          ('0' + parseInt(rgb[2], 10).toString(16)).slice(-2) +
          ('0' + parseInt(rgb[3], 10).toString(16)).slice(-2)
      : '';
  },
};

export default _;

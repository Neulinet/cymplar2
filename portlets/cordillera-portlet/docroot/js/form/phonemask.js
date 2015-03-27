// using: https://github.com/igorescobar/jQuery-Mask-Plugin
// version: v0.5.0+

var SPphoneMask = function(phone, e, currentField, options){
  return phone.match(/^(\(?11\)? ?9(5[0-9]|6[0-9]|7[01234569]|8[0-9]|9[0-9])[0-9]{1})/g) ? '(00) 00000-0000' : '(00) 0000-0000';
};

$(".sp_celphones").mask(SPphoneMask, {onKeyPress: function(phone, e, currentField, options){
  $(currentField).mask(SPphoneMask(phone), options);
}});
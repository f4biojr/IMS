
function isIP(obj) {
 var ary = obj.value.split(".");
 var ip = true;

 for (var i in ary) { ip = (!ary[i].match(/^\d{1,3}$/) || (Number(ary[i]) > 255)) ? false : ip; }
 ip = (ary.length != 4) ? false : ip;

 if (!ip) {    // the value is NOT a valid IP address
  obj.style.background = "#D45244";
  obj.value = "IP Inválido";
  obj.select();
 } else { obj.style.background = ""; } // the value IS a valid IP address
}
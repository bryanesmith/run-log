export default function optional(value) {
  var myVal = value;

  const map = function(fn) {
    if (myVal) {
      myVal = fn(myVal);
    }
    return this;
  };

  const orElse = function(other) {
    return myVal ? myVal : other;
  };
  
  return {
    map, orElse
  };
}

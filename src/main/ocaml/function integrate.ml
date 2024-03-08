let integrate f a b n = 
  if n < 1 then 0.
  else 
    let h = (b -. a) /. float_of_int n in
  
    let rec helper i sum =
      if i > float_of_int n then 
        sum
      else
        let first = f (a +. i *. h) in
        let sec = f (a +.(i -. 1.) *. h) in
        helper (i+.1.) (sum +. first +. sec)
    in
  
    helper 0. 1. *. h /. 2.;;


let f x = x ** 3.0 +. 1.0;;
let result = integrate f 0.0 2.0 100;;
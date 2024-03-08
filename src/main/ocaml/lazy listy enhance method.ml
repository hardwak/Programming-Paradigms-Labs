type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

let rec lpowiel list =
  match list with
  | LNil -> LNil
  | LCons(x, lazy xf) ->
      let rec lpowielHelper n acc =
        if n > 0 then LCons(x, lazy (lpowielHelper (n - 1) acc))
        else acc
      in
      lpowielHelper x (lpowiel xf);;

(*wyklad*)
let rec toLazyList xs =
  match xs with
  | [] -> LNil
  | h::t -> LCons(h, lazy (toLazyList t));; 
(*wyklad*)
let rec ltake = function
    (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x,lazy xs)) -> x::ltake(n-1,xs);; 
  
let res = lpowiel (toLazyList [5;2;3;4]);;
ltake (20, res);;
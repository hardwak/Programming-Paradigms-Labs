let changelst lst count =
  let rec helper acc1 acc2 counter = 
    if counter = 0 || acc1 = [] then acc1 @ acc2
    else
      let acc2' =  acc2 @ [List.hd acc1] in
      let acc1' = List.tl acc1 in
      helper acc1' acc2' (counter - 1)
  in
  helper lst [] count ;;
(*a replace function that divides a given list into two sublists at a given point and returns the list resulting from swapping these sublists.*)
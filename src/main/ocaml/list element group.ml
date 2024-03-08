let group lst  = 
  let rec helper lst acc facc = 
    match lst with
    | [] -> facc @ [acc]
    | hd::tl -> 
        if acc = [] then
          helper tl [hd] facc
        else if hd = List.hd acc then
          helper tl (acc @ [hd]) facc
        else
          helper tl [hd] (facc @ [acc]) 
  in
  helper lst [] [];;
group ["1";"1";"1";"1";"2";"3";"3";"1";"1";"4";"4"];;
group [];;
group [1;3;4;5;1;1;1;1;1;1;1;5];;
group [1];;
group [1;1;1;1;1;1];;
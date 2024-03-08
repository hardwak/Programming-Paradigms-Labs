let unique lst =
    let count_reps acc x =
      let count = List.fold_left(fun count elem-> if elem=x then count + 1 else count) 0 lst in
      if count=1 then x :: acc else acc
    in
  List.fold_left count_reps [] lst;;
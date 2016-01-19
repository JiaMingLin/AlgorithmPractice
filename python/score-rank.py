import operator
def update(sc_map, score):
   # upate the count of score
   sc_map[score] = sc_map.get(score,0)+1
   return sc_map

def rank(scores):
   # convert the score list to score-count map
   sc_map = reduce(lambda bucket, score: update(bucket,score), scores, {})
   # sort the score-count map by key(score)
   sorted_sc_map_key = list(reversed(sorted(sc_map.keys())))
   print sc_map
   aggregated_list = reduce(lambda acct, score: acct+[acct[-1]+sc_map[score]] , sorted_sc_map_key, [1])
   return dict(zip(sorted_sc_map_key, aggregated_list))

scores = [100,55,33,67, 68,33,100,54,87,33,75,71]
ranked_scores = rank(scores)
print ranked_scores

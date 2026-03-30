def witersige(hight):
    if len(hight)== 0 :
        return 0
    left=0
    right = len(hight)-1
    left_max = hight[left]
    right_max = hight[right]
    water = 0
    while left < right :
        if left_max <right_max :
            left += 1
            left_max = max(left_max , hight[left])
            water += left_max - hight[left]
            
        else:
            right -= 1
            right_max = max(right_max , hight[right])
            water += right_max - hight[right]
    return water
height = [0,1,0,2,1,0,1,3,2,1,2,1]
a = witersige(height)
print(a)
def step_fish(lanternfish):
    "Step through a day."
    new_fish = dict(lanternfish)
    for i in range(8):
        new_fish[i] = lanternfish[i+1]
    new_fish[8] = lanternfish[0]  # new fish are born
    new_fish[6] += lanternfish[0]  # fish reset to 6 days
    return new_fish


lanternfish = {0: 0, 1: 0, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0, 7: 0, 8: 0}
with open("resources/06-file.txt", "r") as f:
    for fish in f.readlines()[0].split(","):
        lanternfish[int(fish)] += 1
days = 256
new_fish = lanternfish
for i in range(days):
    new_fish = step_fish(new_fish)

print(sum(new_fish.values()))
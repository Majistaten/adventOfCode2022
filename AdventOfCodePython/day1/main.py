import resources as res

FILE_PATH = res.dayOneFilePath


def most_calories() -> str:

    with open(FILE_PATH, "r") as file:
        elf_number = 1
        most_calories = {"elf": 0, "calories": 0}
        current_elf_calories = 0
        for value in file.readlines():
            if value == "\n":
                if current_elf_calories > most_calories.get("calories"):
                    most_calories["elf"] = elf_number
                    most_calories["calories"] = current_elf_calories
                elf_number += 1
                current_elf_calories = 0
                continue
            current_elf_calories += int(value)
    return f'Elf {most_calories.get("elf")} carries the most calories with {most_calories.get("calories")} calories'


if __name__ == '__main__':
    most_calories()

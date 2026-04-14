import pandas as pd
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split, cross_val_score
from sklearn.neighbors import KNeighborsClassifier
from sklearn.preprocessing import StandardScaler

# 1. NAČTENÍ DAT
# Předpokládáme, že soubor je ve stejné složce jako skript
soubor = 'pima-indians-diabetes_with_header.csv'
df = pd.read_csv(soubor)

# Zobrazení prvních pár řádků pro kontrolu
print("Ukázka načtených dat:")
print(df.head(), "\n")

# ==========================================
# 2. ÚKOL: TVORBA HISTOGRAMU
# Vykreslíme histogram pro rozložení věku (age)
# ==========================================
plt.figure(figsize=(8, 5))
plt.hist(df['age'], bins=20, color='skyblue', edgecolor='black')
plt.title('Histogram věku pacientů')
plt.xlabel('Věk')
plt.ylabel('Počet (frekvence)')
plt.grid(axis='y', alpha=0.75)
plt.show()

# ==========================================
# PŘÍPRAVA DAT PRO STROJOVÉ UČENÍ
# ==========================================
# Oddělení vstupních příznaků (X) a cílové proměnné/třídy (y)
X = df.drop('label', axis=1) # Vše kromě sloupce 'label'
y = df['label']              # Pouze sloupec 'label' (0 = bez diabetu, 1 = diabetes)

# Algoritmus k-NN měří vzdálenosti, proto je nutné data standardizovat (převést na stejné měřítko)
scaler = StandardScaler()
X_scaled = scaler.fit_transform(X)

# ==========================================
# 3. ÚKOL: KŘÍŽOVÁ VALIDACE A k-NN (k=3)
# ==========================================

# Vytvoření k-NN modelu, v PDF padla otázka "Co když k=3?"
knn = KNeighborsClassifier(n_neighbors=3)

# A) 3-složková křížová validace (jak bylo zmíněno v PDF)
# Model se 3x natrénuje a otestuje na různých částech dat
cv_scores = cross_val_score(knn, X_scaled, y, cv=3)
print("--- Výsledky 3-složkové křížové validace ---")
print(f"Přesnost v jednotlivých iteracích: {cv_scores}")
print(f"Průměrná přesnost modelu: {cv_scores.mean() * 100:.2f} %\n")

# B) Klasické rozdělení na trénovací a testovací sadu (např. 80 % trénink, 20 % test)
X_train, X_test, y_train, y_test = train_test_split(X_scaled, y, test_size=0.2, random_state=42)

# Natrénování modelu na trénovacích datech
knn.fit(X_train, y_train)

# Otestování přesnosti na datech, která model nikdy neviděl
accuracy = knn.score(X_test, y_test)
print("--- Výsledek na testovací sadě (80/20 rozdělení) ---")
print(f"Přesnost na testovacích datech: {accuracy * 100:.2f} %")
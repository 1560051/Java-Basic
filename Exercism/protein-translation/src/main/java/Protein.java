public enum Protein {
    AUG("Methionine"),
    UUU("Phenylalanine"), UUC("Phenylalanine"),
    UUA("Leucine"), UUG("Leucine"),
    UCU("Serine"), UCC("Serine"), UCA("Serine"), UCG("Serine"),
    UAU("Tyrosine"), UAC("Tyrosine"),
    UGU("Cysteine"), UGC("Cysteine"),
    UGG("Tryptophan");

    private String nameProtein;
    Protein(String name){
        this.nameProtein=name;
    }

    String getName(){
        return this.nameProtein;
    }
}

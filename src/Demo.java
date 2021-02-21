public class Demo {

    private static final String OUTPUT_DIRECTORY = "chords"; // $project/chords
    private static final String OUTPUT_GUITAR = "/guitar"; // $project/output/guitar
    private static final String OUTPUT_UKULELE = "/ukulele"; // $project/output/ukulele
    private static final String OUTPUT_PIANO = "/piano"; // $project/output/piano
    private static final String RESOURCES_DIRECTORY = "res"; // $project/res
    private static final String RESOURCES_DRAWABLE = "drawable"; // $project/res/drawable
    private static final String RESOURCES_SHAPES = "string/shapes.txt"; // $project/res/string/shapes.txt
    private static final int MAX_POSITIONS = 100; // limit of generated images count

    public static void main(String[] args) {

        ChordGenerator chordGenerator = new ChordGenerator(RESOURCES_DIRECTORY, OUTPUT_DIRECTORY, RESOURCES_DRAWABLE, RESOURCES_SHAPES);

        chordGenerator.setWatermarkEnabled(false);
        chordGenerator.setMaxPositionsCount(MAX_POSITIONS);

        chordGenerator.changeOutputDirectory(OUTPUT_DIRECTORY + OUTPUT_GUITAR);
        boolean isGenerated = chordGenerator.generateChord("Dm", ChordGenerator.INSTRUMENT_GUITAR);
        printResult("Guitar", isGenerated);

        /*
        chordGenerator.changeOutputDirectory(OUTPUT_DIRECTORY + OUTPUT_UKULELE);
        isGenerated = chordGenerator.generateChord("C", ChordGenerator.INSTRUMENT_UKULELE);
        printResult("Ukulele", isGenerated);

        chordGenerator.changeOutputDirectory(OUTPUT_DIRECTORY + OUTPUT_PIANO);
        isGenerated = chordGenerator.generateChord("C", ChordGenerator.INSTRUMENT_PIANO);
        printResult("Piano", isGenerated);
        */
    }

    private static void printResult(String text, boolean isGenerated) {
        if (isGenerated) {
            System.out.println(text + ": Done!");
        } else {
            System.out.println(text + ": Some errors...");
        }
    }

}

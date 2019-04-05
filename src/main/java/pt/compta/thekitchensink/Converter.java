package pt.compta.thekitchensink;

public interface Converter<F, X> {
	F convertTo(X source);

	X convertFrom(F source);
}

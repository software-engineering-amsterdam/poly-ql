
TEX_FILES := $(shell ls *.tex | sed 's/.tex//g')
PDF_FILES := $(addsuffix .pdf, $(TEX_FILES))

all: $(PDF_FILES)
renew: clean all

.PHONY: clean
clean:
	rm *.pdf

%.pdf: %.tex
	pdflatex $<

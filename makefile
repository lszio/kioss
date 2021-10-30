SHADOW ?= npx shadow-cljs

start:
	${SHADOW} start

stop:
	${SHADOW} stop

restart:
	${SHADOW} restart

watch/%:
	$(SHADOW) watch $(@F) --debug

compile/%:
	$(SHADOW) compile $(@F) --debug

release/%:
	$(SHADOW) release $(@F) --debug

install:
	npm install

clean:
	rm -rf out/node/*
	rm -rf out/test/*

dist-clean: stop clean
	rm -rf node_modules
	rm -rf .shadow-cljs
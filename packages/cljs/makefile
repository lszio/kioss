SHADOW ?= npx shadow-cljs

# start:
# 	${SHADOW} start

# stop:
# 	${SHADOW} stop

# restart:
# 	${SHADOW} restart

# watch/%:
# 	$(SHADOW) watch $(@F) --debug

# compile/%:
# 	$(SHADOW) compile $(@F) --debug

# release/%:
# 	$(SHADOW) release $(@F) --debug

install:
	npm install

watch:
	export KIOSS="local"; $(SHADOW) watch dev --debug

release:
	$(SHADOW) release dev $(@F) --debug

compile:
	$(SHADOW) compile kioss $(@F) --debug

clean:
	rm -rf .shadow-cljs
	rm -rf target
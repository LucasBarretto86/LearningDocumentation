import Rails from '@rails/ujs'

const Util = {

  /*
   * Combines the debouce and delegate functions
   */
  debounced_delegate(event, selector, callback, wait, immediate) {
    const fn = debounce(callback, wait, immediate)
    Rails.delegate(document, selector, event, fn)
  },

  /*
   * Returns a function, that, as long as it continues to be invoked, will not
   * be triggered. The function will be called after it stops being called for
   * N milliseconds. If `immediate` is passed, trigger the function on the
   * leading edge, instead of the trailing.
   */
  debounce(func, wait, immediate) {
    let timeout

    return function () {
      const context = this
      const args = arguments
      const later = function () {
        timeout = null
        if (!immediate) func.apply(context, args)
      }
      const callNow = immediate && !timeout
      clearTimeout(timeout)
      timeout = setTimeout(later, wait)
      if (callNow) func.apply(context, args)
    }
  },

  throttle(func, limit) {
    let inThrottle

    return function () {
      const args = arguments
      const context = this
      if (!inThrottle) {
        func.apply(context, args)
        inThrottle = true
        // eslint-disable-next-line no-return-assign
        setTimeout(() => inThrottle = false, limit)
      }
    }
  },

  /*
   * Checks the current position of the screen
   */
  scrollY() {
    return window.pageYOffset || window.scrollY
  },

  overflowedX(container) {
    const lastChild = container.lastElementChild
    return container.clientWidth < lastChild.offsetLeft + lastChild.clientWidth
  },

  /*
   * Gets an element position relative to the 0,0 point
   */
  getPosition(element) {
    let xPosition = 0
    let yPosition = 0

    while (element) {
      xPosition += (element.offsetLeft + element.clientLeft)
      yPosition += (element.offsetTop + element.clientTop)
      element = element.offsetParent
    }

    return { x: xPosition, y: yPosition }
  },

  scrollToElement(element, offset = 0) {
    const to = Util.getPosition(element)

    window.scroll({
      top: to.y + offset,
      left: 0,
      behavior: 'smooth'
    })
  },

  scrollElement(element, position, isAbsolute = true) {
    if (!isAbsolute) {
      position.top += element.scrollTop
      position.left += element.scrollLeft
    }

    element.scroll({ top: position.top, left: position.left, behavior: 'smooth' })
  },

  /*
   * Fetches various festalab specific information
   */
  facebookAppId() {
    return document.querySelector('meta[name=\'festalab-facebook-app-id\']').getAttribute('content')
  },

  platform() {
    return document.querySelector('meta[name=\'festalab-platform\']').getAttribute('content')
  },

  locale() {
    return document.querySelector('meta[name=\'festalab-locale\']').getAttribute('content')
  },

  currency() {
    return document.querySelector('meta[name=\'festalab-currency\']').getAttribute('content')
  },

  device() {
    return this.platform().split('')[1]
  },

  isMobile() {
    return /mobile/.test(Util.platform())
  },

  isDesktop() {
    return /desktop/.test(Util.platform())
  },

  deviceIsSupported() {
    return /supported/.test(Util.platform())
  },

  deviceIsUnSupported() {
    return /unsupported/.test(Util.platform())
  },

  deviceCanShare() {
    return Util.deviceIsSupported() && navigator.share
  },

  deviceCanShareFiles() {
    const mockFile = [new File([], 'test.png', {})]
    return Util.deviceCanShare() && navigator.canShare({ files: mockFile })
  },

  media(mobile, desktop) {
    return Util.isMobile() ? mobile : desktop
  }
}

export default Util